package com.concurso;

public class SessaoUsuario {
    private static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static void encerrarSessao() {
        usuarioLogado = null;
    }

    public static boolean isUsuarioLogado() {
        return usuarioLogado != null;
    }
}
