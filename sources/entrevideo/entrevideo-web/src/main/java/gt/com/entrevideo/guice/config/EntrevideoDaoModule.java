package gt.com.entrevideo.guice.config;

import com.google.inject.AbstractModule;
import gt.com.entrevideo.EntrevideoDaoImpl;
import gt.com.entrevideo.dao.EntrevideoDao;

/**
 *
 * @author garfenter
 */
public class EntrevideoDaoModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(EntrevideoDao.class).to(EntrevideoDaoImpl.class);
    }
    
}
