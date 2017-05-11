import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';

import 'reveal.js/css/reveal.css';
import 'object-partners-revealjs-theme';
import 'highlight.js/styles/Androidstudio.css';

const hljs = require('highlight.js');

@Component({
  selector: 'opi-slide-deck',
  templateUrl: './slide-deck.component.pug',
  styleUrls: [ './slide-deck.component.scss' ],
  encapsulation: ViewEncapsulation.None
})
export class SlideDeckComponent implements OnInit {
  @Input() slides: any[][];

  ngOnInit() {
    require.ensure([
      'reveal.js',
      'reveal.js/lib/js/classList.js',
      'reveal.js/lib/js/head.min.js',
      'reveal.js/lib/js/html5shiv.js',
      'highlight.js'
    ], () => {
      const Reveal = require('reveal.js');
      require('reveal.js/lib/js/classList.js');
      require('reveal.js/lib/js/head.min.js');
      require('reveal.js/lib/js/html5shiv.js');

      (window as any).Reveal = Reveal;

      Reveal.initialize({
        history: true,
        margin: 0,
        dependencies: [
          {
            src: require('reveal.js/plugin/markdown/marked.js'),
            async: true,
            callback: () => hljs.initHighlightingOnLoad() },
        ]
      });
    });
  }
}
