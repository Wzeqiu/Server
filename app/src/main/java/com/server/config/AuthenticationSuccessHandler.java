package com.server.config;

import com.alibaba.fastjson.JSONObject;
import com.server.common.vo.Result;
import com.server.user.vo.UserAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


//    @Autowired
//    private FindByIndexNameSessionRepository<? extends Session> sessionRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
//		loginLogService.recordLoginLog(RequestContextHolder.currentRequestAttributes().getSessionId(),
//				user.getUsername(), Constant.系统_会员端, Constant.登录状态_成功, Constant.登录提示_登录成功,
//				HttpUtil.getClientIP(request), UserAgentUtil.parse(request.getHeader("User-Agent")));
//		userAccountService.updateLatelyLoginTime(user.getUserAccountId());
//		SystemSetting systemSetting = systemSettingRepo.findTopByOrderByLatelyUpdateTime();
//        String currentSessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
//        Map<String, ? extends Session> sessionMap = sessionRepository.findByPrincipalName(user.getUsername());
//        for (Map.Entry<String, ? extends Session> entry : sessionMap.entrySet()) {
//            if (!currentSessionId.equals(entry.getKey())) {
//                sessionRepository.deleteById(entry.getKey());
//            }
//        }
//
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(JSONObject.toJSONString(Result.success().setMsg("登录成功")));
        out.flush();
        out.close();
    }
}
