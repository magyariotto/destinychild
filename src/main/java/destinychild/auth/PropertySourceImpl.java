package destinychild.auth;

import com.github.saphyra.authservice.PropertySource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PropertySourceImpl implements PropertySource {
    @Override
    public String getRequestTypeHeader() {
        return "Request-Type";
    }

    @Override
    public String getRestTypeValue() {
        return "rest";
    }

    @Override
    public String getUnauthorizedRedirection() {
        return "";
    }

    @Override
    public String getForbiddenRedirection() {
        return "";
    }

    @Override
    public String getAccessTokenIdCookie() {
        return "cookie_access_token";
    }

    @Override
    public String getUserIdCookie() {
        return "cookie_user_id";
    }

    @Override
    public List<String> getAllowedUris() {
        return Arrays.asList(
                "/",
                "/**/favicon.ico",
                "/css/**",
                "/img/**",
                "/js/**",
                "/register",
                "/user/name/exist"
        );
    }

    @Override
    public Map<String, Set<String>> getRoleSettings() {
        return new HashMap<>();
    }

    @Override
    public boolean isMultipleLoginAllowed() {
        return false;
    }

    @Override
    public long getTokenExpirationMinutes() {
        return 60;
    }

    @Override
    public int getFilterOrder() {
        return 0;
    }

    @Override
    public String getSuccessfulLoginRedirection() {
        return "home";
    }

    @Override
    public Optional<String> getLogoutRedirection() {
        return Optional.empty();
    }
}
