package api;

import domain.*;

public class SalesProcessImpl implements SalesProcess {
    private MpaRepository mpaRepository;
    private OwnerRepository ownerRepository;

    public Result add(ID masterpieceId, Resolution resolution, ID userId){
        MasterpieceAvailability masterpiece = mpaRepository.load(masterpieceId)
        Owner owner = ownerRepository.load(userId)

        if (masterpiece.isAvailablePer(owner, resolution)){
            masterpiece.reservedPer(owner, resolution)//zmiana

            mpaRepository.save(masterpiece)
            return new Result(OK)
        }

        return new Result("ERROR", "dzieło niedostepne");
    }

    //remove

    public Offer generateOffer(ID userId){
        //pobrac dzieła, ktore zerezwwoal wlasciciel skojarzony z userem
        IList<MasterpieceAvailability> reservedMasterpieces = find(userId)
        Owner owner = ownerRepository.load(userId)

        ISet<Product> productsToAdd = new ...

        //dla dzieła:
        for(MasterpieceAvailability masterpiece : reservedMasterpieces){
            ////czy wciaz dostepne
            if (!masterpiece.isStillAvailablePer(owner))
                continue;
            //dobrac politykę wyceniania
            Definition definition = definitionFactory.Create(masterpiece)

            //wycenic produkt z dzieła
            discountPolicy = disFactory.create(owner)//<<<<<<<<<<<<<<
            ISet<Product> products = definition.appraise(masterpiece, discountPolicy)//wyceń

            productsToAdd.addAll(products)//dodac do oferty
        }

        //zwrocic ofertę
        return new Offer(productsToAdd);
    }

    public Result buy(ID userId, Offer oldOffer){
        Offer newOffer = generateOffer(userId)
        delta = ...
        if (!newOffer.sameAs(oldOffer, delta)){
            return new Result(ERROR, PRICES_CHANGED, newOffer)
        }

        Payer payer = payerRepository.load(userId)
        //sprawdzic czy klienta stać
        if (!payer.canAfford(newOffer.totalCost))
            return new Result(ERROR, NOT_ENOUGH_MONEY, newOffer.totalCost)
        //pobrno opłatę
        Payment payment = payer.charge(newOffer.totalCost, new Cause("....."))
        paymentRepository.save(payment)

        //zablokowac dzieła na amen
        for (Product product : newOffer.items){
            MasterpieceAvailability masterpiece = masterpieceRepo.load(product.nr)
            masterpiece.soldPer(owner, product.resolution)
            Purchase purchase = purchaseFactory.create(product, owner)
            purchaseRepository.save(purchase)
        }

        //odblokowano pliko do pobrania

        //fakturowanie wybranych pozycji

        //wydruk wybranych
    }

}
