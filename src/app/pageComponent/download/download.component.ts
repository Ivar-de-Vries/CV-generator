import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';

@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.scss', '../../styles.scss']
})
export class DownloadComponent implements OnInit {
  userId!: number;

  constructor(
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.userId = Number(this.route.snapshot.paramMap.get('id'));
  }

  @ViewChild('thisIsPrint', { static: false }) el!: ElementRef;

  title = 'onderzoekFrameworkjsPDF';

  makePDF() {

    let data = document.getElementById('thisIsPrint');

    html2canvas(data!).then((canvas) => {
      const FULL_COLOR = 255;
      const MARGE = 5;
      const BOT_MARGE = 20;
      const TOP_MARGE = 20;

      let PDF = new jsPDF('p', 'mm', 'a4');
      let pageWidth = 250;
      let pageHeight = PDF.internal.pageSize.height;

      let contextHeight = pageHeight - BOT_MARGE;
      let htmlHeight = canvas.height * pageWidth / canvas.width;
      let htmlWidth = pageWidth - (MARGE * 2);

      let totalPDFPages = Math.ceil(htmlHeight / contextHeight) - 1;

      let imgData = canvas.toDataURL('image/png', 1.0);
      PDF.addImage(imgData, 'PNG', MARGE, MARGE, htmlWidth, htmlHeight);
      PDF.setFillColor(FULL_COLOR, FULL_COLOR, FULL_COLOR);
      PDF.rect(0, pageHeight- BOT_MARGE, htmlWidth, BOT_MARGE, 'F');
      for (let i = 1; i <= totalPDFPages; i++) {
        PDF.addPage();
        PDF.setPage(i + 1);
        let  extraPagePosY = -(pageHeight* i) + (BOT_MARGE * i) + (TOP_MARGE*i) +(MARGE*i);
        PDF.addImage(imgData, 'PNG', MARGE, extraPagePosY , htmlWidth, htmlHeight);
        PDF.setFillColor(FULL_COLOR, FULL_COLOR, FULL_COLOR);
        PDF.rect(0, 0, htmlWidth, TOP_MARGE, 'F');
        PDF.setFillColor(FULL_COLOR, FULL_COLOR, FULL_COLOR);
        PDF.rect(0, pageHeight- BOT_MARGE, htmlWidth, BOT_MARGE, 'F');
      }
      PDF.save('cv.pdf');
    });
  }
}
