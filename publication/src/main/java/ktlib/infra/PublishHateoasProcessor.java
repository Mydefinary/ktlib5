package ktlib.infra;

import ktlib.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PublishHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Publish>> {

    @Override
    public EntityModel<Publish> process(EntityModel<Publish> model) {
        return model;
    }
}
