package collok;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Window extends JFrame {

    private final JTextArea inputArea;
    private final JTextArea outputArea;
    private final ArrayList<Car> cars;
    private Strategy method;

    Window(String name) {
        super(name);
        cars = new ArrayList<>();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputArea = new JTextArea();
        add(inputArea);
        JButton add = new JButton("Add new Car");
        add(add);
        JButton open = new JButton("add file with info");
        add(open);
        JButton findByStream = new JButton("Find by stream");
        add(findByStream);
        JButton usualFind = new JButton("usual find");
        add(usualFind);
        outputArea = new JTextArea();
        add(outputArea);

        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Scanner scanner = new Scanner(JOptionPane.showInputDialog(null, "Enter name, price, year of production and year of disposal"));
                try {
                    cars.add(new Car(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                showInput();
            }
        });

        open.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        Scanner scanner = new Scanner(fileChooser.getSelectedFile());
                        cars.clear();
                        while (scanner.hasNext()) {
                            cars.add(new Car(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
                        }
                        showInput();
                    } catch (IllegalArgumentException | FileNotFoundException | InputMismatchException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        findByStream.addActionListener(e -> {
            sortUsingStrategy(new StreamFindStrategy());
        });

        usualFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sortUsingStrategy(new FindStrategy());
            }
        });
    }

    private void sortUsingStrategy(Strategy s) {
        Scanner scanner = new Scanner(JOptionPane.showInputDialog(null, "Enter ageFrom and ageTo using space."));
        int yearOfDisposal = scanner.nextInt();
        int yearOfManufacture = scanner.nextInt();
        try {
            if (!Car.rightBound(yearOfDisposal, yearOfManufacture))
                throw new IllegalArgumentException("year of disposal less than a year of release");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        setStrategy(s);
        showOutput(method.getSortedArray(cars, yearOfDisposal, yearOfManufacture));
    }

    private void setStrategy(Strategy strategy) {
        method = strategy;
    }

    public static void main(String[] args) {
        Window chooser = new Window("UIStrategy");
        chooser.pack();
        chooser.setSize(1000, 500);
        chooser.setLocation(300, 150);
        chooser.setVisible(true);
    }

    private void showOutput(ArrayList<Car> output) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : output) {
            stringBuilder.append(car).append("\n");
        }
        outputArea.setText(stringBuilder.toString());
    }

    private void showInput() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString()).append("\n");
        }
        inputArea.setText(stringBuilder.toString());
    }

}
