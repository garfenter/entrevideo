/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.papiro.gae.support;

import java.lang.reflect.Field;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author garfenter
 */
@Aspect
public class WatchSessionBeanModification {
 
    private static ThreadLocal<Boolean> threadLocalFlag = new ThreadLocal<Boolean>();
 
    public static boolean wasModified() {
        return Boolean.TRUE.equals(threadLocalFlag.get());
    }
    private void markChanged() {
        threadLocalFlag.set(true);
    }
    @Around("set(!static !final !transient * (@javax.enterprise.context.SessionScoped *) . *) "
        + "&& args(newVal) && target(t)")
    public final void afterSetField(final ProceedingJoinPoint jp,
            final Object t, final Object newVal) throws Throwable {
        final Object oldVal = getOldVal(jp, t);
        if((oldVal != null && !oldVal.equals(newVal) )||
            (newVal != null && !newVal .equals(oldVal))) {
            markChanged();
        }
        jp.proceed();
    }
    private Object getOldVal(final ProceedingJoinPoint jp, final Object t) throws Exception{
        final Field field = t.getClass().getDeclaredField(jp.getSignature().getName());
        field.setAccessible(true);
        return field.get(t);
    }
}