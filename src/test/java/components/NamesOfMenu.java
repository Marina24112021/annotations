package components;

import java.util.Hashtable;

public class NamesOfMenu {
    private final Hashtable<String, String> nameOfMenuAndDiscription = new Hashtable<String,String>();
    public Hashtable<String, String> getMenuAndDescription() {
        addTitle();
        return this.nameOfMenuAndDiscription;
    }
    private final String[] nameOfMenu = {
            "Это как",
            "Это баг",
            "Как решить",
            "Не стыдно",
            "Что как",
            "Ахах"
    };
    private final String[] descriptionOfMenu = {
            "Инструмент тестирования Postman: зачем нужен, как работает, что умеет",
            "Играем в двадцать одно на компьютере",
            "Задача про умножение и деление, которая делит общество пополам",
            "База по вёрстке: самые основы CSS",
            "Попробуйте: переводчик кошачьего языка",
            "Пояснительная бригада: тыжпрограммист"
    };

    private void addTitle(){
        for( int i = 0; i<nameOfMenu.length; i++){
            nameOfMenuAndDiscription.put(nameOfMenu[i], descriptionOfMenu[i]);
        }
    }
}
