package com.example.appconversao;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class HelloController {

    @FXML
    private TextField textReal, textDollar, textEuro, textYen;

    // Taxas de conversão fictícias, ajuste conforme necessário
    private final double TAXA_USD_BRL = 5.09;
    private final double TAXA_EUR_BRL = 5.47;
    private final double TAXA_JPY_BRL = 0.033;

    @FXML
    protected void updateCurrencies(KeyEvent event) {
        TextField source = (TextField) event.getSource();

        try {
            double valor = Double.parseDouble(source.getText().replace(",", "."));
            switch (source.getId()) {
                case "textReal":
                    textDollar.setText(String.format("%.2f", valor / TAXA_USD_BRL));
                    textEuro.setText(String.format("%.2f", valor / TAXA_EUR_BRL));
                    textYen.setText(String.format("%.2f", valor / TAXA_JPY_BRL));
                    break;
                case "textDollar":
                    double valorReal = valor * TAXA_USD_BRL;
                    textReal.setText(String.format("%.2f", valorReal));
                    textEuro.setText(String.format("%.2f", valorReal / TAXA_EUR_BRL));
                    textYen.setText(String.format("%.2f", valorReal / TAXA_JPY_BRL));
                    break;
                case "textEuro":
                    valorReal = valor * TAXA_EUR_BRL;
                    textReal.setText(String.format("%.2f", valorReal));
                    textDollar.setText(String.format("%.2f", valorReal / TAXA_USD_BRL));
                    textYen.setText(String.format("%.2f", valorReal / TAXA_JPY_BRL));
                    break;
                case "textYen":
                    valorReal = valor * TAXA_JPY_BRL;
                    textReal.setText(String.format("%.2f", valorReal));
                    textDollar.setText(String.format("%.2f", valorReal / TAXA_USD_BRL));
                    textEuro.setText(String.format("%.2f", valorReal / TAXA_EUR_BRL));
                    break;
            }
        } catch (NumberFormatException e) {
            // Limpar todos os campos se a entrada não for válida
            textReal.clear();
            textDollar.clear();
            textEuro.clear();
            textYen.clear();
        }
    }
}
