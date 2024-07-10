package spring.poc.taskspring_poc_crud;
// back end router: accept the request and process

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class basicrest {
    private int[] customerBalances = {
            15000, 8000, 12000, 4500, 20000, 9000, 3000, 10000, 500, 25000,
            7000, 11000, 3500, 18000, 4000, 6000, 13000, 2000, 14000, 17000
    };

    @GetMapping("/balances")
    public int[] getAllBalances() {
        return customerBalances;
    }

    @PutMapping("/applyCharges")
    public int[] applyCharges() {
        for (int i = 0; i < customerBalances.length; i++) {
            if (customerBalances[i] >= 5000 && customerBalances[i] < 10000) {
                customerBalances[i] -= (customerBalances[i] * 0.03);
            } else if (customerBalances[i] >= 1000 && customerBalances[i] < 5000) {
                customerBalances[i] -= (customerBalances[i] * 0.05);
            }
        }
        return customerBalances;
    }

    @GetMapping("/balance/{index}")
    public int getBalance(@PathVariable("index") int index) {
        return customerBalances[index];
    }
}

