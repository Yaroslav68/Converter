package converter;

import converter.animation.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    private static final String INPUT_ERROR_MESSAGE = "Введите число";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputNumber;

    @FXML
    private TextField newAmount;


    @FXML
    private ComboBox<?> comboBox2;

    @FXML
    private ComboBox<?> comboBox1;

    @FXML
    private Button buttonResult;

    @FXML
    private Button buttonClear;

    @FXML
    private ComboBox<?> comboBox;

    @FXML
    void clear(ActionEvent event) {

    }

    @FXML
    void result(ActionEvent event) {
        try {
            errors();
            double result = Integer.valueOf(inputNumber.getText());
            if ("мм".equals(comboBox2.getValue())) {
                if ("см".equals(comboBox1.getValue())) {
                    result /= 10;
                }
                if ("дм".equals(comboBox1.getValue())) {
                    result /= 100;
                }
                if ("м".equals(comboBox1.getValue())) {
                    result /= 1000;
                }
                if ("км".equals(comboBox1.getValue())) {
                    result /= 1000000;
                }
            }
            if ("см".equals(comboBox2.getValue())) {
                if ("мм".equals(comboBox1.getValue())) {
                    result *= 10;
                }
                if ("дм".equals(comboBox1.getValue())) {
                    result /= 100;
                }
                if ("м".equals(comboBox1.getValue())) {
                    result /= 100;
                }
                if ("км".equals(comboBox1.getValue())) {
                    result /= 100000;
                }
            }
            if ("дм".equals(comboBox2.getValue())) {
                if ("мм".equals(comboBox1.getValue())) {
                    result *= 100;
                }
                if ("см".equals(comboBox1.getValue())) {
                    result *= 10;
                }
                if ("м".equals(comboBox1.getValue())) {
                    result /= 10;
                }
                if ("км".equals(comboBox1.getValue())) {
                    result /= 10000;
                }
            }
            if ("м".equals(comboBox2.getValue())) {
                if ("см".equals(comboBox1.getValue())) {
                    result *= 100;
                }
                if ("мм".equals(comboBox1.getValue())) {
                    result *= 1000;
                }
                if ("дм".equals(comboBox1.getValue())) {
                    result *= 10;
                }
                if ("км".equals(comboBox1.getValue())) {
                    result /= 1000;
                }
            }
            if (" км".equals(comboBox2.getValue())) {
                if ("мм".equals(comboBox1.getValue())) {
                    result *= 1000000;
                }
                if ("см".equals(comboBox1.getValue())) {
                    result *= 100000;
                }
                if ("дм".equals(comboBox1.getValue())) {
                    result *= 10000;
                }
                if ("м".equals(comboBox1.getValue())) {
                    result *= 1000;
                }
            }
            newAmount.setText(String.valueOf(result));
        } catch (Exception e) {
            inputNumber.setText(INPUT_ERROR_MESSAGE);
        }

    }

    private void errors() {
        if (inputNumber.getText().isEmpty()) {
            Shake number1Anim = new Shake(inputNumber);

            number1Anim.playAnimation();

            return;
        }
    }

    private void animation() {
        Shake operandAnimation = new Shake(inputNumber);
        operandAnimation.playAnimation();
    }
}
