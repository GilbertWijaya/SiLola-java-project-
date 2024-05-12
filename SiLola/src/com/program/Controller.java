package com.program;

import com.views.DashboardView;
import com.views.StartView;

public class Controller {

    private static StartView frameLoginDanDaftarUser = new StartView();

    public static void showLoginUser(){
        frameLoginDanDaftarUser.setVisible(false);
        frameLoginDanDaftarUser.initsLoginUser();
        frameLoginDanDaftarUser.setVisible(true);
    }

    public static void showDaftarUser(){
        frameLoginDanDaftarUser.setVisible(false);
        frameLoginDanDaftarUser.initsDaftarUser();
        frameLoginDanDaftarUser.setVisible(true);
    }

    public static void showDashboard(Integer id){

        DashboardView dashboardUser = new DashboardView(id);
        dashboardUser.setVisible(true);

    }

}
