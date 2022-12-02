package Main;

import Decorators.DataSourceDecorator;
import Decorators.EncryptionDecorator;
import Decorators.FileDataSource;
import Interfaces.DataSource;

public class Main {
    public static void main(String[] args) {
        String data = "Name: DIMA, Age: 18";
        DataSourceDecorator coded = new EncryptionDecorator(
                new FileDataSource("../__FILES__/input.txt"));
        coded.writeData(data);
        DataSource encoded = new FileDataSource("../__FILES__/output.txt");
        encoded.writeData(data);
    }
}
