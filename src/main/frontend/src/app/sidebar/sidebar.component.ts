import { Component, OnInit } from '@angular/core';

declare var $:any;

export interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}

export const ROUTES: RouteInfo[] = [
    { path: 'tournois', title: 'Tournois',  icon: 'ti-cup', class: '' },
    { path: 'user/1', title: 'Profile',  icon:'ti-user', class: '' },
    { path: 'messageries', title: 'Messages',  icon:'ti-email', class: '' },
    { path: 'consoles', title: 'Consoles',  icon:'ti-view-list-alt', class: '' },
    { path: 'jeux', title: 'Jeux',  icon:'ti-game', class: '' },
    //{ path: 'jeux', title: 'Icons',  icon:'ti-pencil-alt2', class: '' },
    { path: 'journalistes', title: 'Journalistes',  icon:'ti-sharethis', class: '' },
    { path: 'actualites', title: 'Actualites',  icon:'ti-facebook', class: '' },
    { path: 'boutique', title: 'Boutique',  icon:'ti-shopping-cart', class: '' },
    //{ path: '', title: 'Deconnexion',  icon:'ti-export', class: 'active-pro' },
];

@Component({
    moduleId: module.id,
    selector: 'sidebar-cmp',
    templateUrl: 'sidebar.component.html',
})

export class SidebarComponent implements OnInit {
    public menuItems: any[];
    ngOnInit() {
        this.menuItems = ROUTES.filter(menuItem => menuItem);
    }
    isNotMobileMenu(){
        if($(window).width() > 991){
            return false;
        }
        return true;
    }

}
