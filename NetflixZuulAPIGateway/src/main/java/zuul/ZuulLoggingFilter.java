package zuul;

import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;


@Component
public class ZuulLoggingFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;  //izmjena na true
	}

	@Override
	public int filterOrder() {
		return 1; //redoslijed
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre"; //pre after kada da se izvrsi
	}
	

}
