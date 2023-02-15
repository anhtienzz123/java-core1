package reactive.section03;

import com.github.javafaker.Faker;
import reactive.Utils;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {

    public static void main(String[] args) {
        Flux.generate(synsSink -> {
            String country = Faker.instance().country().name();
            synsSink.next(country);

            if (country.equals("Viet Nam")) {
                synsSink.complete();
            }
        }).subscribe(Utils.defaultSubscriber());
    }
}
