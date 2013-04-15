package gt.com.papiro.gae.integration.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Replaces the If-Modified-Since header until Google App Engine bug 8415 is
 * resolved.
 *
 * @see http://code.google.com/p/googleappengine/issues/detail?id=8415
 *
 * @author Derek Berube, Wildstar Technologies
 *
 */
public class HttpIfModifiedSinceFix implements Filter {

    private static final String _CLASS = HttpIfModifiedSinceFix.class.getName();

    /**
     * Called by the web container to indicate to a filter that it is being
     * taken out of service.
     */
    @Override
    public void destroy() {
    }

    /**
     * The
     * <code>doFilter</code> method of the Filter is called by the container
     * each time a request/response pair is passed through the chain due to a
     * client request for a resource at the end of the chain.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest;        
        HttpServletRequestWrapper requestWrapper;        

        httpRequest = (HttpServletRequest) request;
        requestWrapper = new HttpModifiedSinceRequestWrapper(httpRequest);
        chain.doFilter(requestWrapper, response);


    }

    /**
     * Called by the web container to indicate to a filter that it is being
     * placed into service.
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
    }
}