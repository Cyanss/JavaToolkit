package cyan.toolkit.chief;

import cyan.toolkit.chief.service.BuilderAdvice;
import cyan.toolkit.chief.service.InfoService;
import cyan.toolkit.rest.RestException;

import java.util.Date;

/**
 * <p>RestService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:00 2020/11/3
 */
public abstract class ChiefService<M extends ChiefModel<M,E>,E extends ChiefEntity<E,M>,F extends ChiefFilter> extends InfoService<Long, M, E, F> implements BuilderAdvice<Long,M, E> {

    @Override
    protected E createEntity(M model) throws RestException {
        return model.toEntity();
    }

    @Override
    protected M createModel(E entity) throws RestException {
        return entity.toModel();
    }
}
