package runner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * 方法拦截 实现一些log 或者其他的事情
 * 参考链接:https://unmi.cc/extend-junit-4-customized-runner/
 *
 */

public class MyJunitRunner extends BlockJUnit4ClassRunner {


    private Class<?> clazz;
    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @param klass
     * @throws InitializationError if the test class is malformed.
     */
    public MyJunitRunner(Class<?> klass) throws InitializationError {
        super(klass);
        this.clazz=klass;
    }


    @Override
    protected Statement withBeforeClasses(Statement statement) {

        final Statement tmpStatement = super.withBeforeClasses(statement);

        return  new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println( " beforeClass: "  + clazz.getSimpleName());
                tmpStatement.evaluate();  //执行被before class 注解的方法
            }
        };
    }

    @Override
    protected Statement withBefores(FrameworkMethod method, Object target, Statement statement) {
        final Statement tmpStatement = super.withBefores(method, target, statement);
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println(" before before method: " + clazz.getSimpleName());
                tmpStatement.evaluate();
                System.out.println(" after before method: " + clazz.getSimpleName());
            }
        };
    }
}
