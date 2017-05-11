import { Component } from '@angular/core';

const context = require.context('../slides', true, /\.md|markdown|pug$/);

const getSortObject = (name: string) => {
    const [ , folderName, fileName ] = name.split('/');
    return {
        folder: parseInt(folderName.split('-').shift(), 10),
        file: parseInt(fileName.split('.').shift(), 10),
        fileName
    };
};

const slides: any[][] = context.keys()
  .sort((a: string, b: string) => {
    const aSort = getSortObject(a);
    const bSort = getSortObject(b);
    const folderDiff = aSort.folder - bSort.folder;

    if ( folderDiff === 0 ) {
      return aSort.file - bSort.file;
    }
    return folderDiff;
  })
  .reduce((newSlides: any[][], key: string) => {
    const [ , folderName ] = key.split('/');
    const index = parseInt(folderName.split('-').shift(), 10);
    if ( !newSlides[index] ) {
      newSlides[index] = [];
    }
    newSlides[index].push(context(key));
    return newSlides;
  }, []);

@Component({
  selector: 'app-root',
  templateUrl: './app.component.pug'
})
export class AppComponent {
  slides: any[][] = slides;
}
