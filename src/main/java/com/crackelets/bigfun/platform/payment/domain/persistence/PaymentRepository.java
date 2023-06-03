package com.crackelets.bigfun.platform.payment.domain.persistence;

import com.crackelets.bigfun.platform.payment.domain.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByDate(Date date);

}
