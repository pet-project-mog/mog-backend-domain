module br.com.caelum.mog.domain {
    requires hibernate.jpa;
    requires spring.core;
    exports br.com.caelum.mog.domain.models;
    exports br.com.caelum.mog.domain.repositories;
}