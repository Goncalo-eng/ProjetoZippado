package erp.app.company;

import erp.app.exception.UnknownCompanyKeyException;
import erp.core.exception.UnknownCompanyException;  //verificar nome da exceção com belgas
import erp.core.ErpManager;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//classes imported

/** 
 * Shows what a company supplies: product, units, price factor and selling price.
 */
class DoShowCompanyProducts extends Command<ErpManager> {

  DoShowCompanyProducts(ErpManager receiver) {
    super(Label.SHOW_COMPANY_PRODUCTS, receiver);
    addIntegerField("companyId", Prompt.companyId());
  }

  @Override
  protected final void execute() throws CommandException {
    //FIXME implement command
    int companyId = integerField("companyId");

    try {
      List<String> products = _receiver.getCompanyProducts(companyId); //verificar nome com Belgas
      for (String product: products) {
        _display.addLine(product);
      }
      if (!products.isEmpty()){
        _display.display();
      } 
    } catch (UnknownCompanyException e) {
      throw new UnknownCompanyKeyException(companyId)
    }
  }
}
