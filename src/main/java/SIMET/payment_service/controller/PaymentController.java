// package SIMET.payment_service.controller;

// import SIMET.payment_service.model.Payment;
// import SIMET.payment_service.service.PaymentService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/payments")
// public class PaymentController {
//     @Autowired
//     private PaymentService paymentService;

//     @PostMapping
//     public Payment createPayment(@RequestBody Payment payment) {
//         return paymentService.savePayment(payment);
//     }
// }

package SIMET.payment_service.controller;

import SIMET.payment_service.model.Payment;
import SIMET.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    // Bỏ phương thức createPayment gốc để tập trung vào createPaymentFromBonita

    @PostMapping("/from-bonita")
    public Payment createPaymentFromBonita(@RequestBody Payment payment) {
        try {
            // Lưu dữ liệu payment vào MongoDB
            Payment savedPayment = paymentService.savePayment(payment);

            // Ghi log hoặc thực hiện các hành động khác ở đây

            return savedPayment;
        } catch (Exception e) {
            // Xử lý các ngoại lệ khi lưu dữ liệu
            e.printStackTrace();
            throw new RuntimeException("Error creating payment from Bonita: " + e.getMessage());
        }
    }
}
