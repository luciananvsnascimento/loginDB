package br.gov.sp.fatecdiadema.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Constantes do DB:
    public static final String DATABASE_NAME = "dados.db";
    public static final String TABLE_NAME = "pessoas";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USUARIO";
    public static final String COL_3 = "SENHA";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, USUARIO TEXT, SENHA INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean inserirDados(String usuario, int senha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, usuario);
        contentValues.put(COL_3, senha);
        long resultado = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return resultado != -1;
    }

    public Cursor obterSenhaPorUsuario(String usuario) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COL_3};
        String selection = COL_2 + " = ?";
        String[] selectionArgs = {usuario};
        return db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
    }

    public boolean atualizarDados(String usuario, int novaSenha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, novaSenha);  // Atualizar a coluna SENHA
        int linhasAfetadas = db.update(TABLE_NAME, contentValues, COL_2 + " = ?", new String[]{usuario});
        db.close();
        return linhasAfetadas > 0;
    }

    public boolean deletarDados(String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        int linhasAfetadas = db.delete(TABLE_NAME, COL_2 + " = ?", new String[]{usuario});
        db.close();
        return linhasAfetadas > 0;
    }
}




