
package sigelab.web.controller.seguridad.filtro;

import sigelab.core.bean.seguridad.UsuarioBean;
import sigelab.web.utilitarios.NetUtil;
import sigelab.web.utilitarios.VO;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class LoginFilter implements Filter{

	private int ajaxSessionExpiredErrorCode;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//Log the IP address and current timestamp.
		System.out.println("IP "+ NetUtil.getClientIpAddr(request) + ", Time " + new Date().toString());
		
		HttpSession currentSession = request.getSession(false);
		String uri = ((HttpServletRequest) request).getRequestURI();
		String path = ((HttpServletRequest) request).getContextPath();
		String ajaxHeader = ((HttpServletRequest) request).getHeader("X-Requested-With");
		System.out.println("LoginFilter uri " + uri);
		if (currentSession == null) {
			
			if (	uri.equalsIgnoreCase(path + "/") 	) {
				
				chain.doFilter(request, response);
			
			}else if ("XMLHttpRequest".equals(ajaxHeader)) {
				
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendError(this.ajaxSessionExpiredErrorCode);
	
			} else {
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect(path+"/");
			}
			
		} else {
			
			UsuarioBean usuario = (UsuarioBean) currentSession.getAttribute("usuarioSesion");
			
			String accesoURL = path + "/inicioController/controlAcceso";
			String resourcesURL = path + "/resources";
			String app_assetsURL = path + "/app-assets";
			String assetsURL = path + "/assets";
			
			boolean accesoRequest = uri.startsWith(accesoURL);
			boolean resourcesRequest = uri.startsWith(resourcesURL);
			boolean app_assetsRequest = uri.startsWith(app_assetsURL);
			boolean assetsRequest = uri.startsWith(assetsURL);
			
			if(usuario != null){
				if(!VO.isEmpty(usuario.getNombreUsuario())){
					if(usuario.getNombreUsuario().equals("NV")){
						usuario = null;
					}
				}
			}
			
			if (usuario == null) {
				
				if ( uri.equalsIgnoreCase(path + "/") 
					|| accesoRequest
					|| resourcesRequest 
					|| app_assetsRequest 
					|| assetsRequest
				) {
					
					String method = request.getMethod();
					
					if(resourcesRequest || app_assetsRequest || assetsRequest){
						chain.doFilter(request, response);
					}else if(method.equals("GET") && accesoRequest){
						response.sendRedirect(path+"/");
					}else{
						chain.doFilter(request, response);
					}
					
				}else {
					response.sendRedirect(path+"/");
				}
				
			} else {
				
				chain.doFilter(request, response);	
			
			}
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		String ajaxParam = filterConfig.getInitParameter("ajaxSessionExpiredErrorCode");
		
		System.out.println("Ajax Session Expired Param: " + ajaxParam);
		
		ajaxSessionExpiredErrorCode = !VO.isEmpty(ajaxParam) ? VO.toInteger(ajaxParam) : 901;
		
	}

	@Override
	public void destroy() {
		//add code to release any resource
	}

}