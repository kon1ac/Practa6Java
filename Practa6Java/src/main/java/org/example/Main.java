package org.example;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Scanner;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        logger.info("Приложение SoftToyFactory запущено");

        int[] machineCapacities = {100, 150, 200, 80};
        int totalCapacity = calculateTotalProductionCapacity(machineCapacities);
        System.out.println("Общая производственная мощность: " + totalCapacity);

        int totalWorkers = 50;
        double averageProductivity = calculateAverageWorkerProductivity(totalCapacity, totalWorkers);
        System.out.println("Средняя производительность на одного работника: " + averageProductivity);

        boolean[] machineStatus = {true, true, false, true};
        boolean hasBroken = hasBrokenMachines(machineStatus);
        System.out.println("Есть ли неисправные машины на заводе? " + (hasBroken ? "Да" : "Нет"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип мягкой игрушки (медведь, дракончик, жираф): ");
        String toyType = scanner.nextLine();

        System.out.println("Введите количество производимых игрушек: ");
        int quantity = scanner.nextInt();

        produceSoftToys(toyType, quantity);

        scanner.close();

        logger.info("Приложение SoftToyFactory остановлено");
    }

    private static int calculateTotalProductionCapacity(int[] machineCapacities) {
        int totalCapacity = 0;
        for (int capacity : machineCapacities) {
            totalCapacity += capacity;
        }
        return totalCapacity;
    }

    private static double calculateAverageWorkerProductivity(int totalCapacity, int totalWorkers) {
        if (totalWorkers == 0) {
            return 0;
        }
        return (double) totalCapacity / totalWorkers;
    }

    private static boolean hasBrokenMachines(boolean[] machineStatus) {
        for (boolean status : machineStatus) {
            if (!status) {
                return true;
            }
        }
        return false;
    }

    private static void produceSoftToys(String toyType, int quantity) {
        System.out.println("Производим " + quantity + " " + toyType + "... Готово!");
    }
}
