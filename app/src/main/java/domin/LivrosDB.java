package domin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.nandosoft.pi.compra_livros.Livros;

/**
 * Created by Aluno on 20/11/2015.
 */
public class LivrosDB extends SQLiteOpenHelper {
    private static final String TAG = "sqt";
    //Nome do Banco de Dado
    private static final String NOME_BANCO = "LivrariaBanco.sqlite";
    private static final int VERSAO = 1;

    public LivrosDB(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Criando a Tabela livro");
        db.execSQL("CREATE TABLE IF NOT EXISTS LIVRO (_id integer primary key autoencrement," + "livro text, autor text);");
        // CRIANDO NOVO COLONA.
        //db.execSQL("ALTER TABLE (nome nova colona) ADD COLUMN (nome novo campo TEXT)");
        Log.d(TAG, "Tabela livro criada com sucesso.");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public long save(Livros livro) {
        long id = livro.getId();
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("livro", livro.getLivro());

            values.put("autor", livro.getAutor());
            if (id != 0) {
                String _id = String.valueOf(livro.getId());
                String[] whereArgs = new String[]{_id};


                int count = db.update("livro", values, "_id=?", whereArgs);
                return count;
            } else {

                id = db.insert("livro","",values);
                return id;
            }
        } finally {
            db.close();
        }
    }

    public int delete(Livros livro) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("livro", livro.getLivro());
            values.put("autor", livro.getAutor());
            if (id != 0) {
                String _id = String.valueOf(livro.getId());
                String[] whereArgs = new String[]{_id};

                int count = db.delete("livro", values, "_id=?",new String[]{(String.valueOf(livro.getId())});
                Log.i(TAG, "Delete [" + count + "] registro.");
                return count;
                }finally {
                db.close();
            }
        }
    }
}

