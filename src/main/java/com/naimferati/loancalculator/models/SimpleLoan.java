package com.naimferati.loancalculator.models;

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
@Table(name = "simple_loan")
public class SimpleLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "date_created")
    private OffsetDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "date_modified")
    private OffsetDateTime dateModified;

    @Column(name = "loan_amount")
    private Double loanAmount;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "loan_term")
    private Integer loanTerm;

    @Column(name = "month_or_year")
    private String monthOrYear;

    @Column(name = "monthly_payment")
    private Double monthlyPayment;

    @Column(name = "total_interest_paid")
    private Double totalInterestPaid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @Override
    public String toString() {
        return "SimpleLoan{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", loanTerm=" + loanTerm +
                ", monthOrYear='" + monthOrYear + '\'' +
                ", monthlyPayment=" + monthlyPayment +
                ", totalInterestPaid=" + totalInterestPaid +
                ", person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleLoan that = (SimpleLoan) o;
        return Objects.equals(id, that.id) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateModified, that.dateModified) && Objects.equals(loanAmount, that.loanAmount) && Objects.equals(interestRate, that.interestRate) && Objects.equals(loanTerm, that.loanTerm) && Objects.equals(monthOrYear, that.monthOrYear) && Objects.equals(monthlyPayment, that.monthlyPayment) && Objects.equals(totalInterestPaid, that.totalInterestPaid) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreated, dateModified, loanAmount, interestRate, loanTerm, monthOrYear, monthlyPayment, totalInterestPaid, person);
    }
}
