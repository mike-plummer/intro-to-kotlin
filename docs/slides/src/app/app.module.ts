import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { DynamicHTMLModule } from 'ng-dynamic';

import { AppComponent } from './app.component';
import { SlideDeckComponent } from './slide-deck/slide-deck.component';

@NgModule({
  declarations: [
    AppComponent,
    SlideDeckComponent
  ],
  imports: [
    DynamicHTMLModule.forRoot({
      components: []
    }),
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
