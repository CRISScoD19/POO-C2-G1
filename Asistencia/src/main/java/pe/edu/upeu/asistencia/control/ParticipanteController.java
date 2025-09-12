package pe.edu.upeu.asistencia.control;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.servicio.ParticipanteServicioImp;

@Controller
public class ParticipanteController {

    @FXML
    private ComboBox<Carrera>  cbxCarrera;
    @FXML
    private ComboBox<TipoParticipante>  cbxTipoParticipante;

    @FXML
    private TextField txtNombres, txtApellidos, txtDni;

    @FXML
    private TableView<Participante> tableRegPart;
    ObservableList<Participante> participantes;
    @Autowired
    ParticipanteServicioImp ps;
    TableColumn<Participante, String> nombreCol, apellidoCol,dniCol, carreraCol,tipoParticipanteCol;
    TableColumn<Participante, Void> opcCol;
    int indexEdit=-1;

    @FXML
    public void initialize(){
        cbxCarrera.getItems().addAll(Carrera.values());
        cbxTipoParticipante.getItems().addAll(TipoParticipante.values());
        cbxCarrera.getSelectionModel().select(4);
        Carrera carrera = cbxCarrera.getSelectionModel().getSelectedItem();
        System.out.println(carrera.name());
        definirColumnas();
        listarParticipantes();
    }
    public void limpiarFormulario(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDni.setText("");
        cbxCarrera.getSelectionModel().clearSelection();
        cbxTipoParticipante.getSelectionModel().clearSelection();
    }
    @FXML
    public void registrarParticipante(){
        Participante p = new Participante();
        p.setNombre(new SimpleStringProperty(txtNombres.getText()));
        p.setApellidos(new SimpleStringProperty(txtApellidos.getText()));
        p.setDNI(new SimpleStringProperty(txtDni.getText()));
        p.setCarrera(cbxCarrera.getSelectionModel().getSelectedItem());
        p.setTipoParticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
        if(indexEdit==-1) {
            ps.save(p);
        }else{
            ps.update(p, indexEdit);
            indexEdit=-1;
        }
        limpiarFormulario();
        listarParticipantes();

    }
    public void definirColumnas(){
        nombreCol = new TableColumn<>("Nombre");
        apellidoCol = new TableColumn<>("Apellido");
        dniCol = new TableColumn<>("DNI");
        carreraCol = new TableColumn<>("Carrera");
        tipoParticipanteCol = new TableColumn<>("Tipo Participante");
        opcCol = new TableColumn<>("Opciones");
        opcCol.setPrefWidth(200);
        tableRegPart.getColumns().addAll(nombreCol,apellidoCol,dniCol,carreraCol,tipoParticipanteCol,opcCol);
    }
    public void listarParticipantes(){
        nombreCol.setCellValueFactory(cellData ->cellData.getValue().getNombre());
        apellidoCol.setCellValueFactory(cellData ->cellData.getValue().getApellidos());
        dniCol.setCellValueFactory(cellData ->cellData.getValue().getDNI());
        carreraCol.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        tipoParticipanteCol.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getTipoParticipante().toString())
        );
        agregarAccionesButton();
        participantes = FXCollections.observableArrayList(ps.findAll());
        tableRegPart.setItems(participantes);
    }
    public void eliminarParticipante (int index){
        ps.delete(index);
        listarParticipantes();
    }
    public void editarParticipante(Participante p , int index){
        txtNombres.setText(p.getNombre().getValue());
        txtApellidos.setText(p.getApellidos().getValue());
        txtDni.setText(p.getDNI().getValue());
        cbxTipoParticipante.getSelectionModel().select(p.getTipoParticipante());
        cbxCarrera.getSelectionModel().select(p.getCarrera());
        indexEdit=index;

    }
    public void agregarAccionesButton(){
        Callback<TableColumn<Participante, Void>, TableCell<Participante, Void>>
                cellFactory = paran-> new TableCell<>(){
            private final Button btnEdit = new Button("Editar");
            private final Button btnDelet = new Button("Eliminar");
            {
                btnEdit.setOnAction(event->{
                    Participante p = getTableView().getItems().get(getIndex());
                    editarParticipante(p, getIndex());
                });
                btnDelet.setOnAction(event->{
                    eliminarParticipante(getIndex());

                });
            }

          @Override
          public void updateItem(Void item , boolean empty){
              super.updateItem(item, empty);
              if (empty ){
                  setGraphic(null);
              }else{
                  HBox hBox= new HBox(btnEdit,btnDelet);
                  hBox.setSpacing(10);
                  setGraphic(hBox);
              }
          }
        };
        opcCol.setCellFactory(cellFactory);
    }
}
