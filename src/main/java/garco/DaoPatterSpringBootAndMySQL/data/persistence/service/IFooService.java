package garco.DaoPatterSpringBootAndMySQL.data.persistence.service;

import garco.DaoPatterSpringBootAndMySQL.data.persistence.model.Foo;
import garco.DaoPatterSpringBootAndMySQL.persistence.IOperations;

public interface IFooService extends IOperations<Foo> {
    Foo retrieveByName(String name);
}
