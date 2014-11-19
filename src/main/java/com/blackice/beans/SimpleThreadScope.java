package com.blackice.beans;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

/**
 * Thread-backed {@link Scope} implementation.
 *
 * <p><strong>Note</strong> that the <code>SimpleThreadScope</code> <em>does not clean up any objects</em> associated
 * with it. As such, it's typically preferable to use the {@link org.springframework.web.context.request.RequestScope}
 * in Web environments.
 *
 * <p>For a implementation of a thread-based <code>Scope</code> with support for destruction callbacks, refer to <a
 * href="http://www.springbyexample.org/twiki/bin/view/Example/CustomThreadScopeModule">this module</a>.
 *
 * <p>Thanks to Eugene Kuleshov for submitting the original prototype for a thread scope!
 *
 * @author Arjen Poutsma
 * @author Juergen Hoeller
 * @since 3.0
 * @see org.springframework.web.context.request.RequestScope
 */
public class SimpleThreadScope implements Scope {

	private static final Log logger = LogFactory.getLog(SimpleThreadScope.class);

	private final ThreadLocal<Map<String, Object>> threadScope =
			new NamedThreadLocal<Map<String, Object>>("SimpleThreadScope") {
				@Override
				protected Map<String, Object> initialValue() {
					return new HashMap<String, Object>();
				}
			};

	public Object get(String name, ObjectFactory objectFactory) {
		System.out.println("-------------- > get " + name);
		System.out.println("-------------- > get " + objectFactory);
		System.out.println("-------------- > get " + Thread.currentThread().getName());
		
		Map<String, Object> scope = threadScope.get();
		Object object = scope.get(name);
		if (object == null) {
			object = objectFactory.getObject();
			scope.put(name, object);
		}
		return object;
	}

	public Object remove(String name) {
		Map<String, Object> scope = threadScope.get();
		return scope.remove(name);
	}

	public void registerDestructionCallback(String name, Runnable callback) {
		logger.warn("SimpleThreadScope does not support descruction callbacks. " +
				"Consider using a RequestScope in a Web environment.");
	}

	public Object resolveContextualObject(String key) {
		return null;
	}

	public String getConversationId() {
		System.out.println("-------------- > " + Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}

}