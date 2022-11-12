// 로그인 성공 시 "referer" 헤더와 세션을 이용해 이전에 보고있던 페이지로 리다이렉트 시켜주는 SuccessHandler
// *로그인 페이지 조회 시 세션에 미리 "url_prior_login" 이름으로 referer 값을 저장해 놔야 함*
// request.getSession().setAttribute("url_prior_login", request.getHeader("referer"));

@Slf4j
@RequiredArgsConstructor
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException {
        // 1. 세션 조회 - 세션이 없다면 새로 생성하지 않고 null을 반환한다 (false 안하면 새로 생성해준다)
        HttpSession session = request.getSession(false);
        
        // 2-1. 세션이 있다면
        if(session != null) {
            // 세션에 "url_prior_login" 이름으로 저장된 값을 꺼내온다. (referer 헤더를 통해 세션에 미리 담아둔 값)
            String redirectUrl = (String) session.getAttribute("url_prior_login");
            if(redirectUrl != null) {
                // 세션에 저장된 데이터를 지우고 referer 경로(이전에 보고있던 페이지)로 리다이렉트
                session.removeAttribute("url_prior_login");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
                return;
            }
        }
        // 2-2. 세션이 없다면 - 바로 "/" 경로로 리다이렉트
        response.sendRedirect("/");
    }
}
