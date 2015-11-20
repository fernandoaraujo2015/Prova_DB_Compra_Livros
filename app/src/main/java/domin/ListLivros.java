package domin;

import android.app.AlertDialog;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.DatabaseMetaData;

import br.nandosoft.pi.compra_livros.R;

/**
 * Created by Aluno on 20/11/2015.
 */
public class ListLivros {
    private DatabaseMetaData;
    private SimpleAdapter;
    private CursorAdapter;
    private static final String campo[] = {"livro", "autor", "_id"};
    ListView listView;
    LivrosDB livrosDB;

protected void onCreate(Builder.savedInstanceState) {
    super.onCreate(savedInstanceState);

    listView = (ListView) findViewById(R.id.);
    livrosDB = new LivrosDB(this);
    database = livrosDB.getWritableDatabase();
    findViewById(R.id.btn_editar_livro)

    // Chama Listener de Delete.
    listView.setOnItemClickListener(deletarItem())
}
}