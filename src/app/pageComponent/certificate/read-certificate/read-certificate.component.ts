import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CertificateDTO } from 'src/app/dto/CertificateDTO';
import { CertificateService } from 'src/app/service/certificate.service';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { AbstractDelete } from '../../abstractPage/delete-abstract';

@Component({
    selector: 'app-read-certificate',
    templateUrl: './read-certificate.component.html',
    styleUrls: ['./read-certificate.component.scss', '../../../styles.scss']
})

export class ReadCertificateComponent extends AbstractDelete<CertificateDTO> implements OnInit{
    constructor(
        certificateService: CertificateService,
        route: ActivatedRoute,
        errorService: ErrorSubscribeService,
        router: Router
    ) {
        super(certificateService, errorService, route, router, 'certificate');
    }

    getEntityName(entity: CertificateDTO): string {
        return entity.name;
    }
}
