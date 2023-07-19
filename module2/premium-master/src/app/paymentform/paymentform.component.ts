import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PremiumPaymentsService } from '../paymentform.service';
@Component({
  selector: 'app-paymentform',
  templateUrl: './paymentform.component.html',
  styleUrls: ['./paymentform.component.css']
})
export class PaymentformComponent {
  formSubmitted = false;
  premiumForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private premiumPaymentsService: PremiumPaymentsService
  ) {
    this.premiumForm = this.formBuilder.group({
      paymentDate: new Date().toISOString().split('T')[0],
      bankTransactionId: '',
      premiumAmount: '',
      lateFee: '',
      paymentMethodId: 0,
      premiumMasterId: ''
    });
  }

  onSubmit(): void {
    if (this.premiumForm.valid) {
      const premiumPayments = this.premiumForm.value;
      if (!premiumPayments.paymentDate) {
        premiumPayments.paymentDate = new Date();
      }
      this.premiumPaymentsService.addPremiumPayments(premiumPayments)
        .subscribe(() => {
          // Handle successful submission, e.g., show a success message
          this.formSubmitted = true;
          console.log('Premium payments added successfully.');
          this.premiumForm = this.formBuilder.group({
            paymentDate: new Date().toISOString().split('T')[0],
            bankTransactionId: '',
            premiumAmount: '',
            lateFee: '',
            paymentMethodId: 0,
            premiumMasterId: ''
          });
        }, (error) => {
          // Handle error, e.g., show an error message
          console.error('Failed to add premium payments:', error);
        });
    }
  }
}
