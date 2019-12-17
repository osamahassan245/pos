import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { PosSharedModule } from 'app/shared/shared.module';
import { PosCoreModule } from 'app/core/core.module';
import { PosAppRoutingModule } from './app-routing.module';
import { PosHomeModule } from './home/home.module';
import { PosEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { JhiMainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    PosSharedModule,
    PosCoreModule,
    PosHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    PosEntityModule,
    PosAppRoutingModule
  ],
  declarations: [JhiMainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [JhiMainComponent]
})
export class PosAppModule {}
