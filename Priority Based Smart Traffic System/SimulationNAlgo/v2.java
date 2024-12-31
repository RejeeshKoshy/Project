roadNetworkDescriptor.size() ;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot1_expression0_dataSet_xjal = new DataSet( 240, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot1_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );

  public DataSet timeInSystemDS = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), 0 );
      _lastUpdateX = time();
    }

    intersection1 = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road, PathEndType.END ),
			new PathEnd( road5, PathEndType.BEGIN ),
			new PathEnd( road7, PathEndType.END ),
		}, _intersection1_laneConnectors_xjal()
 );

    intersection = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road5, PathEndType.END ),
			new PathEnd( road6, PathEndType.END ),
			new PathEnd( road8, PathEndType.BEGIN ),
			new PathEnd( road1, PathEndType.BEGIN ),
			new PathEnd( road2, PathEndType.END ),
		}, _intersection_laneConnectors_xjal()
 );

    intersection2 = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road4, PathEndType.BEGIN ),
			new PathEnd( road6, PathEndType.BEGIN ),
			new PathEnd( road7, PathEndType.BEGIN ),
			new PathEnd( road3, PathEndType.END ),
			new PathEnd( road8, PathEndType.END ),
			new PathEnd( road9, PathEndType.BEGIN ),
		}, _intersection2_laneConnectors_xjal()
 );

    intersection3 = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road3, PathEndType.BEGIN ),
			new PathEnd( road9, PathEndType.END ),
			new PathEnd( road10, PathEndType.BEGIN ),
		}, _intersection3_laneConnectors_xjal()
 );

    intersection4 = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road4, PathEndType.END ),
			new PathEnd( road11, PathEndType.BEGIN ),
		}, _intersection4_laneConnectors_xjal()
 );

  }


  private void _initialize_roadNetwork_xjal() {
	  roadNetwork.addAll(road4, stopLine9, stopLine8, road, intersection1, intersection, road5, stopLine2, road6, stopLine5, intersection2, road7, stopLine4, road3, road8, stopLine3, road9, stopLine6, intersection3, road10, stopLine7, road1, stopLine, road2, stopLine1, intersection4, road11, stopLine10);
      trafficLight = _trafficLight_xjal();
      roadNetwork.add(trafficLight);
      trafficLight1 = _trafficLight1_xjal();
      roadNetwork.add(trafficLight1);
  }
  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_Main_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
	_initialize_roadNetwork_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Main.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( oliveDrab );
    window3d.setCamera( camera, false );
// Creating replicated embedded objects
    setupInitialConditions_xjal( Main.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    checkbox1.setValueToDefault();
    cbxCameraFollowToCar.setValueToDefault();
    checkbox7.setValueToDefault();
  }

@AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<>();
   


  public AgentList<? extends Main> getPopulation() {
    return (AgentList<? extends Main>) super.getPopulation();
  }

  public List<? extends Main> agentsInRange( double distance ) {
    return (List<? extends Main>) super.agentsInRange( distance );
  }
