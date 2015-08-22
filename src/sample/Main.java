package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    TableView<Product> table ;
    TextField nameInput, phoneInput, emailInput;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setTitle("Table View");

        //name
        TableColumn<Product,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        nameColumn.setOnEditCommit((TableColumn.CellEditEvent<Product,String> t) ->{
                    ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                }
        );



        //phone
        TableColumn<Product,String> phoneColumn = new TableColumn<>("Phone Number");
        phoneColumn.setMinWidth(200);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneColumn.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        phoneColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
                    ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                }
        );

        //email
        TableColumn<Product,String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));emailColumn.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        emailColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
                    ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                }
        );



        nameInput = new TextField();
        nameInput.setPromptText("Enter the name");
        nameInput.setMinWidth(100);

        phoneInput = new TextField();
        phoneInput.setPromptText("Enter the phone number");
        phoneInput.setMinWidth(100);

        emailInput = new TextField();
        emailInput.setPromptText("Enter the email address");
        emailInput.setMinWidth(100);


        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());

        Button delButton = new Button("Delete");
        delButton.setOnAction(e -> delButtonClicked());


        HBox hBox= new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.getChildren().addAll(nameInput, phoneInput, emailInput, addButton, delButton);


        table=new TableView<>();
        table.setEditable(true);
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, phoneColumn, emailColumn);

        VBox vBox = new VBox();

        vBox.getChildren().addAll(table,hBox);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked(){
        Product product= new Product();
        product.setName(nameInput.getText());
        product.setPhone(phoneInput.getText());
        product.setEmail(emailInput.getText());
        table.getItems().add(product);
        nameInput.clear();
        phoneInput.clear();
        emailInput.clear();

    }
    public void delButtonClicked(){
        ObservableList<Product> productSelected,allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);
    }

    public  ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add((new Product("Arfaa","9008827850","arfah.ns@gmail.com")));

        return products;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
