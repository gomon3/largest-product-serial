/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestproduct;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import largestproduct.calculo.Calculating;

/**
 * FXML Controller class
 *
 * @author Vaio
 */
public class FXMLMainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label remainingTestCases, instruction, dynamicInstruction;
    
    @FXML
    private Button showInputDialoge;
    
    @FXML
    private AnchorPane containerTestCase;
    
    @FXML
    private TextField k, n, number;
    
    
    
    private int t;
    
    @FXML
    protected void addTestCase(ActionEvent e){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Agregar caso de prueba");
        dialog.setHeaderText("Agrega el número de casos de prueba que deseas ejecutar");
        dialog.setContentText("Recuerda que el dato debe ser entre 1 y 100");
        
        
        Optional<String> result = dialog.showAndWait();
        
        if(result.isPresent()){
            
            try{
                
                int t = Integer.parseInt(result.get());
                
                if(t<1 || t>100){
                    
                    showWarning("Debes ingresar un número entero entre 1 y 100");
                    
                }else{
                    
                    this.t = t;
                    this.remainingTestCases.setText("Casos de prueba restantes: " + t);
                    this.remainingTestCases.setVisible(true);
                    
                    this.instruction.setVisible(false);
                    this.showInputDialoge.setVisible(false);
                    
                    this.containerTestCase.setVisible(true);
                    
                }
                
            }catch(Exception ex){
                
                showError("El dato ingresado no es válido");
                
            }
            
        }
        
    }
    
    @FXML
    protected void recommendationEvent(){
        this.dynamicInstruction.setText("Introduzca un número entero de " + this.n.getText() + " dígitos");
    }
    
    @FXML
    protected void getLargestProduct(ActionEvent e){
        
        try{
            int k = Integer.parseInt(this.k.getText());
            int nDig = Integer.parseInt(this.n.getText());
            long n = Long.parseLong(this.number.getText());
            Calculating c = new Calculating(k, nDig, n);
            
            long result = c.getLargestProduct();
            
            
            
            this.k.setText("");
            this.n.setText("");
            this.number.setText("");
            this.dynamicInstruction.setText("Introduzca un número entero de");
            
            this.t--;
            this.remainingTestCases.setText("Casos de prueba restantes: " + t);
            
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Diálogo informativo");
            alert.setHeaderText("De una serie de " + k + " dígitos");
            alert.setContentText("El producto más grande de la serie es " + result);

            alert.showAndWait();
            
            if(this.t <= 0){
                //Terminaron tus casos de prueba
                this.containerTestCase.setVisible(false);
                
                this.instruction.setVisible(true);
                this.showInputDialoge.setVisible(true);
                this.remainingTestCases.setVisible(false);
                
            }
            
            
        }catch(Exception ex){
            showError(ex.getMessage());
        }
        
        
    }
    
    private void showError(String mensaje){
        
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Mensaje de error");
        alert.setHeaderText("Ocurrió un error");
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
    
    private void showWarning(String mensaje){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Mensaje de advertencia");
        alert.setHeaderText("Ocurrió un error");
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
