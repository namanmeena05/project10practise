import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  form: any = {
    data: {} 
  };

  constructor(private httpService: HttpClient) { }

  ngOnInit() {
      this.display()
    
  }

  save() {
    var self = this;
    this.httpService.post('http://localhost:8084/payment/save', this.form.data)
      .subscribe((res: any) => {
       
        self.form.message = res.result.message;
      self.form.error =  res.result.error;
        if (res.success) {
                  self.form.data = res.result.data;
               self.form.data.paymentMode=   res.result.data.paymentMode;
        }
      }, error => {
               console.error('Error occurred while saving:', error);
      });
  }
  display(){
    var self = this;
    this.httpService.get('http://localhost:8084/payment/get/'+ self.form.data.id).subscribe((res:any) =>{
      if(res.success){
        self.form.data =res.result.data;

      }
    })
  }
}
