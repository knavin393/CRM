package com.codebridgecommunity.crm.repository;

import com.codebridgecommunity.crm.domain.ProductOrder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the ProductOrder entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductOrderRepository extends ReactiveCrudRepository<ProductOrder, Long>, ProductOrderRepositoryInternal {
    Flux<ProductOrder> findAllBy(Pageable pageable);

    @Override
    Mono<ProductOrder> findOneWithEagerRelationships(Long id);

    @Override
    Flux<ProductOrder> findAllWithEagerRelationships();

    @Override
    Flux<ProductOrder> findAllWithEagerRelationships(Pageable page);

    @Query("SELECT * FROM product_order entity WHERE entity.customer_id = :id")
    Flux<ProductOrder> findByCustomer(Long id);

    @Query("SELECT * FROM product_order entity WHERE entity.customer_id IS NULL")
    Flux<ProductOrder> findAllWhereCustomerIsNull();

    @Override
    <S extends ProductOrder> Mono<S> save(S entity);

    @Override
    Flux<ProductOrder> findAll();

    @Override
    Mono<ProductOrder> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface ProductOrderRepositoryInternal {
    <S extends ProductOrder> Mono<S> save(S entity);

    Flux<ProductOrder> findAllBy(Pageable pageable);

    Flux<ProductOrder> findAll();

    Mono<ProductOrder> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<ProductOrder> findAllBy(Pageable pageable, Criteria criteria);

    Mono<ProductOrder> findOneWithEagerRelationships(Long id);

    Flux<ProductOrder> findAllWithEagerRelationships();

    Flux<ProductOrder> findAllWithEagerRelationships(Pageable page);

    Mono<Void> deleteById(Long id);
}
