package com.naimferati.loancalculator.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "amortization_schedule")
public class AmortizationSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "date_created")
    private OffsetDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "date_modified")
    private OffsetDateTime dateModified;

    @Column(name = "number_of_payment")
    private Integer numberOfPayment;

    @Column(name = "loan_amount")
    private Double loanAmount;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "number_of_payments")
    private Integer numberOfPayments;

    @Column(name = "payment_frequency")
    private String paymentFrequency;

    @Column(name = "payment_amount")
    private Double paymentAmount;

    @Column(name = "principal_amount")
    private Double principalAmount;

    @Column(name = "interest_amount")
    private Double interestAmount;

    @Column(name = "balance_owed")
    private Double balanceOwed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @Override
    public String toString() {
        return "AmortizationSchedule{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", numberOfPayment=" + numberOfPayment +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", numberOfPayments=" + numberOfPayments +
                ", paymentFrequency='" + paymentFrequency + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", principalAmount=" + principalAmount +
                ", interestAmount=" + interestAmount +
                ", balanceOwed=" + balanceOwed +
                ", person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmortizationSchedule that = (AmortizationSchedule) o;
        return Objects.equals(id, that.id) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateModified, that.dateModified) && Objects.equals(numberOfPayment, that.numberOfPayment) && Objects.equals(loanAmount, that.loanAmount) && Objects.equals(interestRate, that.interestRate) && Objects.equals(numberOfPayments, that.numberOfPayments) && Objects.equals(paymentFrequency, that.paymentFrequency) && Objects.equals(paymentAmount, that.paymentAmount) && Objects.equals(principalAmount, that.principalAmount) && Objects.equals(interestAmount, that.interestAmount) && Objects.equals(balanceOwed, that.balanceOwed) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreated, dateModified, numberOfPayment, loanAmount, interestRate, numberOfPayments, paymentFrequency, paymentAmount, principalAmount, interestAmount, balanceOwed, person);
    }
}
