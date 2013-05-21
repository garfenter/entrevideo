package gt.com.entrevideo.guice.config;

import com.google.inject.AbstractModule;
import gt.com.entrevideo.svc.EntrevideoService;
import gt.com.entrevideo.svc.EntrevideoServiceImpl;
import gt.com.entrevideo.svc.ValueListCatalogImpl;
import gt.com.entrevideo.svc.ValuesListCatalog;

/**
 *
 * @author garfenter
 */
public class EntrevideoServiceModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(ValuesListCatalog.class).to(ValueListCatalogImpl.class);        
        bind(EntrevideoService.class).to(EntrevideoServiceImpl.class);
    }
    
}
