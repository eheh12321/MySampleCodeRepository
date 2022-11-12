// 로그아웃 실패 시 flashMap을 이용해 에러 문구 전달해주는 logoutFailureHandler
// 컨트롤러에서 @ModelAttribute("error") String loginFailureError 로 받아서 사용하면 된다

@Slf4j
@RequiredArgsConstructor
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        if(exception != null) {
            final FlashMap flashMap = new FlashMap();
            if(exception instanceof BadCredentialsException) { // 아이디 혹은 비밀번호 검증 실패시
                flashMap.put("error", "아이디 또는 비밀번호를 확인해주세요");
            } else if(exception instanceof LockedException) { // 계정이 잠겼을 시
                flashMap.put("error", "로그인 시도 횟수 초과로 계정이 잠겼습니다.");
            } else { // 기타
                flashMap.put("error", "로그인에 실패했습니다");
            }
            final FlashMapManager flashMapManager = new SessionFlashMapManager();
            flashMapManager.saveOutputFlashMap(flashMap, request, response); // 세션에다 flashMap 저장
        }
        // 로그인 페이지로 리다이렉트
        response.sendRedirect("/login");
    }
}

