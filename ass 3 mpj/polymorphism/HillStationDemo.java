package polymorphism;

// Parent Class
class Hillstations {
    void famousFood() {
        System.out.println("Local hill station food.");
    }

    void famousFor() {
        System.out.println("Scenic beauty and weather.");
    }

    void bestTimeToVisit() {
        System.out.println("Best time: Pleasant season.");
    }
}

// Subclass 1
class Ooty extends Hillstations {
    @Override
    void famousFood() {
        System.out.println("Ooty is famous for Varkey and homemade chocolate.");
    }

    @Override
    void famousFor() {
        System.out.println("Ooty is famous for tea gardens and Nilgiri hills.");
    }

    @Override
    void bestTimeToVisit() {
        System.out.println("Best time to visit Ooty: April to June.");
    }
}

// Subclass 2
class Shimla extends Hillstations {
    @Override
    void famousFood() {
        System.out.println("Shimla is famous for Babru and Sidu.");
    }

    @Override
    void famousFor() {
        System.out.println("Shimla is famous for Mall Road and snowfall.");
    }

    @Override
    void bestTimeToVisit() {
        System.out.println("Best time to visit Shimla: December to February.");
    }
}

// Subclass 3
class Darjeeling extends Hillstations {
    @Override
    void famousFood() {
        System.out.println("Darjeeling is famous for momos and Darjeeling tea.");
    }

    @Override
    void famousFor() {
        System.out.println("Darjeeling is famous for toy train and tea estates.");
    }

    @Override
    void bestTimeToVisit() {
        System.out.println("Best time to visit Darjeeling: March to May.");
    }
}

public class HillStationDemo {
    public static void main(String[] args) {
        Hillstations place;

        System.out.println("--- Ooty ---");
        place = new Ooty();
        place.famousFood();
        place.famousFor();
        place.bestTimeToVisit();

        System.out.println("\n--- Shimla ---");
        place = new Shimla();
        place.famousFood();
        place.famousFor();
        place.bestTimeToVisit();

        System.out.println("\n--- Darjeeling ---");
        place = new Darjeeling();
        place.famousFood();
        place.famousFor();
        place.bestTimeToVisit();
    }
}
