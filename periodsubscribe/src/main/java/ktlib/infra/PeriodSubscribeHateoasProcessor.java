package ktlib.infra;

import ktlib.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PeriodSubscribeHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PeriodSubscribe>> {

    @Override
    public EntityModel<PeriodSubscribe> process(
        EntityModel<PeriodSubscribe> model
    ) {
        return model;
    }
}
