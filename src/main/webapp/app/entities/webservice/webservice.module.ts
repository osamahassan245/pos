import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PosSharedModule } from 'app/shared/shared.module';
import { WEBSERVICEComponent } from './webservice.component';
import { WEBSERVICEDetailComponent } from './webservice-detail.component';
import { WEBSERVICEUpdateComponent } from './webservice-update.component';
import { WEBSERVICEDeleteDialogComponent } from './webservice-delete-dialog.component';
import { wEBSERVICERoute } from './webservice.route';

@NgModule({
  imports: [PosSharedModule, RouterModule.forChild(wEBSERVICERoute)],
  declarations: [WEBSERVICEComponent, WEBSERVICEDetailComponent, WEBSERVICEUpdateComponent, WEBSERVICEDeleteDialogComponent],
  entryComponents: [WEBSERVICEDeleteDialogComponent]
})
export class PosWEBSERVICEModule {}
