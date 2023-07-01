/*
 * Copyright (C) 2023 Cobblemon Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.cobblemon.mod.common.client.render.models.blockbench.repository

import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.JsonPokemonPoseableModel
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.PokemonPoseableModel
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.gen1.*
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.gen2.*
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.gen3.*
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.gen4.*
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.gen5.*
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.gen6.*
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.gen7.*
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.gen8.*
import com.cobblemon.mod.common.client.render.models.blockbench.pokemon.gen9.*
import com.cobblemon.mod.common.client.render.models.blockbench.pose.Bone
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity
import com.cobblemon.mod.common.util.cobblemonResource

object PokemonModelRepository : VaryingModelRepository<PokemonEntity, PokemonPoseableModel>() {
    override val title = "Pokémon"
    override val type = "pokemon"
    override val variationDirectories = listOf("bedrock/$type/resolvers", "bedrock/species")
    override val poserDirectories = listOf("bedrock/$type/posers", "bedrock/posers")
    override val modelDirectories = listOf("bedrock/$type/models", "bedrock/models")
    override val animationDirectories: List<String> = listOf("bedrock/animations", "bedrock/$type/animations")

    override val fallback = cobblemonResource("substitute")

    override fun registerInBuiltPosers() {
        inbuilt("bulbasaur", ::BulbasaurModel)
        inbuilt("ivysaur", ::IvysaurModel)
        inbuilt("venusaur", ::VenusaurModel)
        inbuilt("charmander", ::CharmanderModel)
        inbuilt("charmeleon", ::CharmeleonModel)
        inbuilt("charizard", ::CharizardModel)
        inbuilt("squirtle", ::SquirtleModel)
        inbuilt("wartortle", ::WartortleModel)
        inbuilt("blastoise", ::BlastoiseModel)
        inbuilt("caterpie", ::CaterpieModel)
        inbuilt("metapod", ::MetapodModel)
        inbuilt("butterfree", ::ButterfreeModel)
        inbuilt("weedle", ::WeedleModel)
        inbuilt("kakuna", ::KakunaModel)
        inbuilt("beedrill", ::BeedrillModel)
        inbuilt("rattata", ::RattataModel)
        inbuilt("raticate", ::RaticateModel)
        inbuilt("eevee", ::EeveeModel)
        inbuilt("magikarp", ::MagikarpModel)
        inbuilt("gyarados", ::GyaradosModel)
        inbuilt("pidgey", ::PidgeyModel)
        inbuilt("pidgeotto", ::PidgeottoModel)
        inbuilt("pidgeot", ::PidgeotModel)
        inbuilt("diglett", ::DiglettModel)
        inbuilt("dugtrio", ::DugtrioModel)
        inbuilt("zubat", ::ZubatModel)
        inbuilt("cleffa", ::CleffaModel)
        inbuilt("clefable", ::ClefableModel)
        inbuilt("clefairy", ::ClefairyModel)
        inbuilt("krabby", ::KrabbyModel)
        inbuilt("paras", ::ParasModel)
        inbuilt("parasect", ::ParasectModel)
        inbuilt("mankey", ::MankeyModel)
        inbuilt("primeape", ::PrimeapeModel)
        inbuilt("oddish", ::OddishModel)
        inbuilt("gloom", ::GloomModel)
        inbuilt("vileplume", ::VileplumeModel)
        inbuilt("bellossom", ::BellossomModel)
        inbuilt("voltorb", ::VoltorbModel)
        inbuilt("electrode", ::ElectrodeModel)
        inbuilt("lapras", ::LaprasModel)
        inbuilt("ekans", ::EkansModel)
        inbuilt("machop", ::MachopModel)
        inbuilt("machoke", ::MachokeModel)
        inbuilt("machamp", ::MachampModel)
        inbuilt("abra", ::AbraModel)
        inbuilt("aerodactyl", ::AerodactylModel)
        inbuilt("alakazam", ::AlakazamModel)
        inbuilt("arbok", ::ArbokModel)
        inbuilt("arcanine", ::ArcanineModel)
        inbuilt("articuno", ::ArticunoModel)
        inbuilt("bellsprout", ::BellsproutModel)
        inbuilt("chansey", ::ChanseyModel)
        inbuilt("cloyster", ::CloysterModel)
        inbuilt("crobat", ::CrobatModel)
        inbuilt("cubone", ::CuboneModel)
        inbuilt("dewgong", ::DewgongModel)
        inbuilt("ditto", ::DittoModel)
        inbuilt("dodrio", ::DodrioModel)
        inbuilt("doduo", ::DoduoModel)
        inbuilt("dragonair", ::DragonairModel)
        inbuilt("dragonite", ::DragoniteModel)
        inbuilt("dratini", ::DratiniModel)
        inbuilt("drowzee", ::DrowzeeModel)
        inbuilt("electabuzz", ::ElectabuzzModel)
        inbuilt("exeggcute", ::ExeggcuteModel)
        inbuilt("exeggutor", ::ExeggutorModel)
        inbuilt("exeggutor_alolan", ::ExeggutorAlolanModel)
        inbuilt("farfetchd", ::FarfetchdModel)
        inbuilt("farfetchd_galarian", ::FarfetchdGalarianModel)
        inbuilt("fearow", ::FearowModel)
        inbuilt("flareon", ::FlareonModel)
        inbuilt("gastly", ::GastlyModel)
        inbuilt("gengar", ::GengarModel)
        inbuilt("geodude", ::GeodudeModel)
        inbuilt("golbat", ::GolbatModel)
        inbuilt("goldeen", ::GoldeenModel)
        inbuilt("golduck", ::GolduckModel)
        inbuilt("golem", ::GolemModel)
        inbuilt("graveler", ::GravelerModel)
        inbuilt("grimer", ::GrimerModel)
        inbuilt("growlithe", ::GrowlitheModel)
        inbuilt("haunter", ::HaunterModel)
        inbuilt("hitmonchan", ::HitmonchanModel)
        inbuilt("hitmonlee", ::HitmonleeModel)
        inbuilt("horsea", ::HorseaModel)
        inbuilt("hypno", ::HypnoModel)
        inbuilt("jigglypuff", ::JigglypuffModel)
        inbuilt("jolteon", ::JolteonModel)
        inbuilt("jynx", ::JynxModel)
        inbuilt("kabuto", ::KabutoModel)
        inbuilt("kabutops", ::KabutopsModel)
        inbuilt("kadabra", ::KadabraModel)
        inbuilt("kangaskhan", ::KangaskhanModel)
        inbuilt("kingler", ::KinglerModel)
        inbuilt("koffing", ::KoffingModel)
        inbuilt("krabby", ::KrabbyModel)
        inbuilt("lickitung", ::LickitungModel)
        inbuilt("magmar", ::MagmarModel)
        inbuilt("magnemite", ::MagnemiteModel)
        inbuilt("magneton", ::MagnetonModel)
        inbuilt("marowak", ::MarowakModel)
        inbuilt("meowth", ::MeowthModel)
        inbuilt("mew", ::MewModel)
        inbuilt("mewtwo", ::MewtwoModel)
        inbuilt("moltres", ::MoltresModel)
        inbuilt("mrmime", ::MrmimeModel)
        inbuilt("muk", ::MukModel)
        inbuilt("nidoking", ::NidokingModel)
        inbuilt("nidoqueen", ::NidoqueenModel)
        inbuilt("nidoranf", ::NidoranfModel)
        inbuilt("nidoranm", ::NidoranmModel)
        inbuilt("nidorina", ::NidorinaModel)
        inbuilt("nidorino", ::NidorinoModel)
        inbuilt("ninetales", ::NinetalesModel)
        inbuilt("omanyte", ::OmanyteModel)
        inbuilt("omastar", ::OmastarModel)
        inbuilt("onix", ::OnixModel)
        inbuilt("persian", ::PersianModel)
        inbuilt("pikachu", ::PikachuModel)
        inbuilt("pinsir", ::PinsirModel)
        inbuilt("poliwag", ::PoliwagModel)
        inbuilt("poliwhirl", ::PoliwhirlModel)
        inbuilt("poliwrath", ::PoliwrathModel)
        inbuilt("politoed", ::PolitoedModel)
        inbuilt("ponyta", ::PonytaModel)
        inbuilt("porygon", ::PorygonModel)
        inbuilt("psyduck", ::PsyduckModel)
        inbuilt("raichu", ::RaichuModel)
        inbuilt("rapidash", ::RapidashModel)
        inbuilt("rhydon", ::RhydonModel)
        inbuilt("rhyhorn", ::RhyhornModel)
        inbuilt("sandshrew", ::SandshrewModel)
        inbuilt("sandslash", ::SandslashModel)
        inbuilt("scyther", ::ScytherModel)
        inbuilt("seadra", ::SeadraModel)
        inbuilt("seaking", ::SeakingModel)
        inbuilt("seel", ::SeelModel)
        inbuilt("shellder", ::ShellderModel)
        inbuilt("slowbro", ::SlowbroModel)
        inbuilt("slowpoke", ::SlowpokeModel)
        inbuilt("snorlax", ::SnorlaxModel)
        inbuilt("spearow", ::SpearowModel)
        inbuilt("starmie", ::StarmieModel)
        inbuilt("staryu", ::StaryuModel)
        inbuilt("steelix", ::SteelixModel)
        inbuilt("tangela", ::TangelaModel)
        inbuilt("tauros", ::TaurosModel)
        inbuilt("tentacool", ::TentacoolModel)
        inbuilt("tentacruel", ::TentacruelModel)
        inbuilt("vaporeon", ::VaporeonModel)
        inbuilt("venomoth", ::VenomothModel)
        inbuilt("venonat", ::VenonatModel)
        inbuilt("victreebel", ::VictreebelModel)
        inbuilt("vulpix", ::VulpixModel)
        inbuilt("weepinbell", ::WeepinbellModel)
        inbuilt("weezing", ::WeezingModel)
        inbuilt("wigglytuff", ::WigglytuffModel)
        inbuilt("zapdos", ::ZapdosModel)
        inbuilt("elekid", ::ElekidModel)
        inbuilt("igglybuff", ::IgglybuffModel)
        inbuilt("magby", ::MagbyModel)
        inbuilt("pichu", ::PichuModel)
        inbuilt("smoochum", ::SmoochumModel)
        inbuilt("tyrogue", ::TyrogueModel)
        inbuilt("hitmontop", ::HitmontopModel)
        inbuilt("electivire", ::ElectivireModel)
        inbuilt("glaceon", ::GlaceonModel)
        inbuilt("happiny", ::HappinyModel)
        inbuilt("leafeon", ::LeafeonModel)
        inbuilt("lickilicky", ::LickilickyModel)
        inbuilt("magmortar", ::MagmortarModel)
        inbuilt("magnezone", ::MagnezoneModel)
        inbuilt("mimejr", ::MimejrModel)
        inbuilt("munchlax", ::MunchlaxModel)
        inbuilt("porygon2", ::Porygon2Model)
        inbuilt("porygonz", ::PorygonzModel)
        inbuilt("rhyperior", ::RhyperiorModel)
        inbuilt("scizor", ::ScizorModel)
        inbuilt("tangrowth", ::TangrowthModel)
        inbuilt("sylveon", ::SylveonModel)
        inbuilt("umbreon", ::UmbreonModel)
        inbuilt("espeon", ::EspeonModel)
        inbuilt("blissey", ::BlisseyModel)
        inbuilt("kingdra", ::KingdraModel)
        inbuilt("piloswine", ::PiloswineModel)
        inbuilt("quagsire", ::QuagsireModel)
        inbuilt("slowking", ::SlowkingModel)
        inbuilt("swinub", ::SwinubModel)
        inbuilt("wooper", ::WooperModel)
        inbuilt("yanma", ::YanmaModel)
        inbuilt("blaziken", ::BlazikenModel)
        inbuilt("combusken", ::CombuskenModel)
        inbuilt("marshtomp", ::MarshtompModel)
        inbuilt("minun", ::MinunModel)
        inbuilt("mudkip", ::MudkipModel)
        inbuilt("plusle", ::PlusleModel)
        inbuilt("rayquaza", ::RayquazaModel)
        inbuilt("swampert", ::SwampertModel)
        inbuilt("torchic", ::TorchicModel)
        inbuilt("bibarel", ::BibarelModel)
        inbuilt("bidoof", ::BidoofModel)
        inbuilt("buneary", ::BunearyModel)
        inbuilt("empoleon", ::EmpoleonModel)
        inbuilt("lopunny", ::LopunnyModel)
        inbuilt("mamoswine", ::MamoswineModel)
        inbuilt("pachirisu", ::PachirisuModel)
        inbuilt("piplup", ::PiplupModel)
        inbuilt("prinplup", ::PrinplupModel)
        inbuilt("yanmega", ::YanmegaModel)
        inbuilt("basculin", ::BasculinModel)
        inbuilt("crustle", ::CrustleModel)
        inbuilt("dwebble", ::DwebbleModel)
        inbuilt("emolga", ::EmolgaModel)
        inbuilt("maractus", ::MaractusModel)
        inbuilt("bounsweet", ::BounsweetModel)
        inbuilt("dartrix", ::DartrixModel)
        inbuilt("decidueye", ::DecidueyeModel)
        inbuilt("incineroar", ::IncineroarModel)
        inbuilt("litten", ::LittenModel)
        inbuilt("mimikyu", ::MimikyuModel)
        inbuilt("naganadel", ::NaganadelModel)
        inbuilt("poipole", ::PoipoleModel)
        inbuilt("rowlet", ::RowletModel)
        inbuilt("steenee", ::SteeneeModel)
        inbuilt("torracat", ::TorracatModel)
        inbuilt("tsareena", ::TsareenaModel)
        inbuilt("centiskorch", ::CentiskorchModel)
        inbuilt("sizzlipede", ::SizzlipedeModel)
        inbuilt("kleavor", ::KleavorModel)
        inbuilt("pyukumuku", ::PyukumukuModel)
        inbuilt("deerling", ::DeerlingModel)
        inbuilt("sawsbuck", ::SawsbuckModel)
        inbuilt("sableye", ::SableyeModel)
        inbuilt("natu", ::NatuModel)
        inbuilt("xatu", ::XatuModel)
        inbuilt("wailmer", ::WailmerModel)
        inbuilt("wailord", ::WailordModel)
        inbuilt("murkrow", ::MurkrowModel)
        inbuilt("honchkrow", ::HonchkrowModel)
        inbuilt("nacli", :: NacliModel)
        inbuilt("naclstack", :: NaclstackModel)
        inbuilt("garganacl", ::GarganaclModel)
        inbuilt("dhelmise", :: DhelmiseModel)
        inbuilt("alcremie", :: AlcremieModel)
        inbuilt("milcery", :: MilceryModel)
        inbuilt("turtwig", :: TurtwigModel)
        inbuilt("grotle", :: GrotleModel)
        inbuilt("torterra", :: TorterraModel)
        inbuilt("xerneas", :: XerneasModel)
        inbuilt("klink", :: KlinkModel)
        inbuilt("klang", :: KlangModel)
        inbuilt("klinklang", :: KlinklangModel)
        inbuilt("morelull", :: MorelullModel)
        inbuilt("shiinotic", :: ShiinoticModel)
        inbuilt("joltik", :: JoltikModel)
        inbuilt("galvantula", :: GalvantulaModel)
        inbuilt("riolu", :: RioluModel)
        inbuilt("lucario", :: LucarioModel)
        inbuilt("treecko", :: TreeckoModel)
        inbuilt("grovyle", :: GrovyleModel)
        inbuilt("sceptile", :: SceptileModel)
        inbuilt("honedge", :: HonedgeModel)
        inbuilt("spiritomb", :: SpiritombModel)
        inbuilt("baltoy", :: BaltoyModel)
        inbuilt("claydol", :: ClaydolModel)
        inbuilt("chespin", :: ChespinModel)
        inbuilt("quilladin", :: QuilladinModel)
        inbuilt("chesnaught", :: ChesnaughtModel)
        inbuilt("elgyem", :: ElgyemModel)
        inbuilt("beheeyem", :: BeheeyemModel)
        inbuilt("gible", :: GibleModel)
        inbuilt("gabite", :: GabiteModel)
        inbuilt("garchomp", :: GarchompModel)
        inbuilt("pineco", :: PinecoModel)
        inbuilt("forretress", :: ForretressModel)
        inbuilt("doublade", :: DoubladeModel)
        inbuilt("aegislash", :: AegislashModel)
        inbuilt("lotad", :: LotadModel)
        inbuilt("lombre", :: LombreModel)
        inbuilt("ludicolo", :: LudicoloModel)
        inbuilt("golett", :: GolettModel)
        inbuilt("golurk", :: GolurkModel)
        inbuilt("stantler", :: StantlerModel)
        inbuilt("wyrdeer", :: WyrdeerModel)
        inbuilt("sneasel", :: SneaselModel)
        inbuilt("weavile", :: WeavileModel)
        inbuilt("bergmite", :: BergmiteModel)
        inbuilt("avalugg", :: AvaluggModel)
        inbuilt("misdreavus", :: MisdreavusModel)
        inbuilt("mismagius", :: MismagiusModel)
        inbuilt("whismur", :: WhismurModel)
        inbuilt("loudred", :: LoudredModel)
        inbuilt("exploud", :: ExploudModel)
        inbuilt("luvdisc", :: LuvdiscModel)
        inbuilt("cryogonal", :: CryogonalModel)
        inbuilt("sigilyph", :: SigilyphModel)
        inbuilt("pumpkaboo", :: PumpkabooModel)
        inbuilt("gourgeist", :: GourgeistModel)
        inbuilt("eiscue", :: EiscueModel)
        inbuilt("tatsugiri", :: TatsugiriModel)
        inbuilt("wooloo", :: WoolooModel)
        inbuilt("dubwool", :: DubwoolModel)
        inbuilt("chimchar", :: ChimcharModel)
        inbuilt("monferno", :: MonfernoModel)
        inbuilt("infernape", :: InfernapeModel)
        inbuilt("popplio", :: PopplioModel)
        inbuilt("brionne", :: BrionneModel)
        inbuilt("primarina", ::PrimarinaModel)
        inbuilt("spinda", ::SpindaModel)
        inbuilt("seedot", ::SeedotModel)
        inbuilt("nuzleaf", ::NuzleafModel)
        inbuilt("shiftry", ::ShiftryModel)
        inbuilt("kricketot", ::KricketotModel)
        inbuilt("kricketune", ::KricketuneModel)
        inbuilt("heatmor", ::HeatmorModel)
        inbuilt("durant", ::DurantModel)
        inbuilt("carvanha", ::CarvanhaModel)
        inbuilt("sharpedo", ::SharpedoModel)
        inbuilt("mawile", ::MawileModel)
        inbuilt("walkingwake", ::WalkingwakeModel)
        inbuilt("ironleaves", ::IronleavesModel)
        inbuilt("miltank", ::MiltankModel)
        inbuilt("torkoal", ::TorkoalModel)
        inbuilt("fennekin", ::FennekinModel)
        inbuilt("braixen", ::BraixenModel)
        inbuilt("delphox", ::DelphoxModel)
        inbuilt("froakie", ::FroakieModel)
        inbuilt("frogadier", ::FrogadierModel)
        inbuilt("greninja", ::GreninjaModel)
        inbuilt("tepig", ::TepigModel)
        inbuilt("pignite", ::PigniteModel)
        inbuilt("emboar", ::EmboarModel)
        inbuilt("grookey", ::GrookeyModel)
        inbuilt("thwackey", ::ThwackeyModel)
        inbuilt("rillaboom", ::RillaboomModel)
        inbuilt("scorbunny", ::ScorbunnyModel)
        inbuilt("raboot", ::RabootModel)
        inbuilt("cinderace", ::CinderaceModel)
        inbuilt("sobble", ::SobbleModel)
        inbuilt("drizzile", ::DrizzileModel)
        inbuilt("inteleon", ::InteleonModel)
        inbuilt("oshawott", ::OshawottModel)
        inbuilt("dewott", ::DewottModel)
        inbuilt("samurott", ::SamurottModel)
        inbuilt("snivy", ::SnivyModel)
        inbuilt("servine", ::ServineModel)
        inbuilt("serperior", ::SerperiorModel)
        inbuilt("slugma", ::SlugmaModel)
        inbuilt("magcargo", ::MagcargoModel)
        inbuilt("nosepass", ::NosepassModel)
        inbuilt("probopass", ::ProbopassModel)
        inbuilt("chinchou", ::ChinchouModel)
        inbuilt("clamperl", ::ClamperlModel)
        inbuilt("huntail", ::HuntailModel)
        inbuilt("gorebyss", ::GorebyssModel)
        inbuilt("spinarak", ::SpinarakModel)
        inbuilt("ariados", ::AriadosModel)
        inbuilt("shuckle", ::ShuckleModel)
        inbuilt("taillow", ::TaillowModel)
        inbuilt("swellow", ::SwellowModel)
        inbuilt("relicanth", ::RelicanthModel)
        inbuilt("mudbray", ::MudbrayModel)
        inbuilt("mudsdale", ::MudsdaleModel)
        inbuilt("comfey", ::ComfeyModel)
        inbuilt("tandemaus", ::TandemausModel)
        inbuilt("maushold", ::MausholdModel)
        inbuilt("mausholdfour", ::MausholdfourModel)
        inbuilt("varoom", ::VaroomModel)
        inbuilt("revavroom", ::RevavroomModel)
        inbuilt("lanturn", ::LanturnModel)
        inbuilt("chingling", ::ChinglingModel)
        inbuilt("chimecho", ::ChimechoModel)
        inbuilt("fidough", ::FidoughModel)
        inbuilt("dachsbun", ::DachsbunModel)
        inbuilt("chatot", ::ChatotModel)
        inbuilt("gligar", ::GligarModel)
        inbuilt("gliscor", ::GliscorModel)
        inbuilt("poochyena", ::PoochyenaModel)
        inbuilt("mightyena", ::MightyenaModel)
        inbuilt("sprigatito", ::SprigatitoModel)
        inbuilt("floragato", ::FloragatoModel)
        inbuilt("meowscarada", ::MeowscaradaModel)
        inbuilt("shroomish", ::ShroomishModel)
        inbuilt("breloom", ::BreloomModel)
        inbuilt("charcadet", ::CharcadetModel)
        inbuilt("armarouge", ::ArmarougeModel)
        inbuilt("ceruledge", ::CeruledgeModel)
        inbuilt("flittle", ::FlittleModel)
        inbuilt("espathra", ::EspathraModel)
        inbuilt("surskit", ::SurskitModel)
        inbuilt("masquerain", ::MasquerainModel)
        inbuilt("cutiefly", ::CutieflyModel)
        inbuilt("ribombee", ::RibombeeModel)
        inbuilt("carnivine", ::CarnivineModel)
        inbuilt("falinks", ::FalinksModel)
        inbuilt("stufful", ::StuffulModel)
        inbuilt("bewear", ::BewearModel)
        inbuilt("scatterbug", ::ScatterbugModel)
        inbuilt("spewpa", ::SpewpaModel)
        inbuilt("vivillon", ::VivillonModel)
        inbuilt("barboach", ::BarboachModel)
        inbuilt("whiscash", ::WhiscashModel)
        inbuilt("combee", ::CombeeModel)
        inbuilt("vespiquen", ::VespiquenModel)
        inbuilt("lillipup", ::LillipupModel)
        inbuilt("herdier", ::HerdierModel)
        inbuilt("stoutland", ::StoutlandModel)
        inbuilt("sirfetchd", ::SirfetchdModel)
        inbuilt("rookidee", ::RookideeModel)
        inbuilt("corvisquire", ::CorvisquireModel)
        inbuilt("corviknight", ::CorviknightModel)
        inbuilt("duskull", ::DuskullModel)
        inbuilt("dusclops", ::DusclopsModel)
        inbuilt("dusknoir", ::DusknoirModel)
        inbuilt("nickit", ::NickitModel)
        inbuilt("thievul", ::ThievulModel)
        inbuilt("cacnea", ::CacneaModel)
        inbuilt("cacturne", ::CacturneModel)
        inbuilt("glimmet", ::GlimmetModel)
        inbuilt("glimmora", ::GlimmoraModel)
        inbuilt("bonsly", ::BonslyModel)
        inbuilt("sudowoodo", ::SudowoodoModel)
        inbuilt("bouffalant", ::BouffalantModel)
        inbuilt("cetoddle", ::CetoddleModel)
        inbuilt("cetitan", ::CetitanModel)
        inbuilt("venipede", ::VenipedeModel)
        inbuilt("whirlipede", ::WhirlipedeModel)
        inbuilt("scolipede", ::ScolipedeModel)


        // Unhooked because the families are not completed
//        inbuilt("fuecoco", :: FuecocoModel)
//        inbuilt("quaxly", :: QuaxlyModel)

    }

    override fun loadJsonPoser(json: String): (Bone) -> PokemonPoseableModel {
        return {
            JsonPokemonPoseableModel.JsonPokemonPoseableModelAdapter.modelPart = it
            JsonPokemonPoseableModel.gson.fromJson(json, JsonPokemonPoseableModel::class.java)
        }
    }
}